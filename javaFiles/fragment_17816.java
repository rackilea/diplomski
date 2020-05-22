while ($true) {
    $a = Get-DnsClientCache | ForEach-Object { $_.Name }
    if ($a -contains 'the.dns.com') {
        Start-Process C:\path\to\music.exe -Wait
        Clear-DnsClientCache
    }
}