( '+-/*+−÷×' | 
    Get-CharInfo | 
        Format-Table -HideTableHeaders | 
            Out-String
).Split( [System.Environment]::NewLine,
         [System.StringSplitOptions]::RemoveEmptyEntries ) |
    ForEach-Object { $_.Trim() } |
        Sort-Object -Unique