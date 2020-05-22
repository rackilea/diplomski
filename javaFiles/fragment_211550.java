<#
_get-CharInfo_1.1.ps1

Origin   by: http://poshcode.org/5234
             sorry, the above link is not available; last time checked 2018-05-07
Improved by: https://stackoverflow.com/users/3439404/josefz

Use this like this: "ábč",([char]'x'),0xBF | Get-CharInfo

Activate dot-sourced like this (apply a real path instead of .\):

. .\_get-CharInfo_1.1.ps1
#>

Add-Type -Name UName -Namespace Microsofts.CharMap -MemberDefinition $(
    switch ("$([System.Environment]::SystemDirectory -replace 
                '\\', '\\')\\getuname.dll") {
    {Test-Path -LiteralPath $_ -PathType Leaf} {@"
[DllImport("${_}", ExactSpelling=true, SetLastError=true)]
private static extern int GetUName(ushort wCharCode, 
    [MarshalAs(UnmanagedType.LPWStr)] System.Text.StringBuilder buf);

public static string Get(char ch) {
    var sb = new System.Text.StringBuilder(300);
    UName.GetUName(ch, sb);
    return sb.ToString();
}
"@
    }
    default {'public static string Get(char ch) { return "???"; }'}
    })

function Get-CharInfo {
    [CmdletBinding()]
    [OutputType([System.Management.Automation.PSCustomObject],[System.Array])]
    param(
        [Parameter(Position=0, Mandatory=$true, ValueFromPipeline=$true)]
        $InputObject
    )
    begin {
        Set-StrictMode -Version latest
        function out {
            param(
                [Parameter(Position=0, Mandatory=$true )] $ch,
                [Parameter(Position=1, Mandatory=$false)]$nil=''
                 )
            if (0 -le $ch -and 0xFFFF -ge $ch) {
                [pscustomobject]@{
                    Char = [char]$ch
                    CodePoint = 'U+{0:X4}' -f $ch
                    Category = [System.Globalization.CharUnicodeInfo]::GetUnicodeCategory($ch)
                    Description = [Microsofts.CharMap.UName]::Get($ch)
                }
            } elseif (0 -le $ch -and 0x10FFFF -ge $ch) {
                $s = [char]::ConvertFromUtf32($ch)
                [pscustomobject]@{
                    Char = $s
                    CodePoint = 'U+{0:X}' -f $ch
                    Category = [System.Globalization.CharUnicodeInfo]::GetUnicodeCategory($s, 0)
                    Description = '???' + $nil
                }
            } else {
                Write-Warning ('Character U+{0:X} is out of range' -f $ch)
            }
        }
    }
    process {
        if ($PSBoundParameters['Verbose']) {
            Write-Warning "InputObject type = $($InputObject.GetType().Name)"}
        if ($null -cne ($InputObject -as [char])) {
            #Write-Verbose "A $([char]$InputObject) InputObject character"
            out $([int][char]$InputObject) ''
        } elseif ($InputObject -isnot [string] -and $null -cne ($InputObject -as [int])) {
            #Write-Verbose "B $InputObject InputObject"
            out $([int]$InputObject) ''
        } else {
            $InputObject = [string]$InputObject
            #Write-Verbose "C $InputObject InputObject.Length $($InputObject.Length)"
            for ($i = 0; $i -lt $InputObject.Length; ++$i) {
                if (  [char]::IsHighSurrogate($InputObject[$i]) -and 
                      (1+$i) -lt $InputObject.Length -and 
                      [char]::IsLowSurrogate($InputObject[$i+1])) {
                    $aux = ' 0x{0:x4},0x{1:x4}' -f [int]$InputObject[$i], 
                                                   [int]$InputObject[$i+1]
                    Write-Verbose "surrogate pair $aux at position $i" 
                    out $([char]::ConvertToUtf32($InputObject[$i], $InputObject[1+$i])) $aux
                    $i++
                } else {
                    out $([int][char]$InputObject[$i]) ''
                }
            }
        }
    }
}