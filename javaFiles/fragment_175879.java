function AddToPath ([string]$path)
{
  $delimeter = ';'
  $path = Get-Item -path $path
  $newEnvPath = $env:path + ";" + $path
  $newEnvPath = ($newEnvPath -split $delimeter | select -Unique) -join $delimeter
  $env:path = $newEnvPath
}