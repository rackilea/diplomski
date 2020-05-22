Add-Type -AssemblyName System.Windows.Forms
Add-Type -AssemblyName System.Drawing

function New-Button($label, $action, $width, $height, $top, $left) {
  $btn = New-Object System.Windows.Forms.Button
  $btn.Location = New-Object System.Drawing.Size($left, $top)
  $btn.Size = New-Object System.Drawing.Size($width, $height)
  $btn.Text = $label
  $btn.Add_Click($action)
  $btn
}

function New-Label($label, $width, $height, $top, $left) {
  $lbl = New-Object System.Windows.Forms.Label
  $lbl.Location = New-Object System.Drawing.Size($left, $top)
  $lbl.Size = New-Object System.Drawing.Size($width, $height)
  $lbl.Text = $label
  $lbl
}

function New-Input($width, $height, $top, $left, $mask=$false) {
  $input = New-Object System.Windows.Forms.TextBox
  $input.UseSystemPasswordChar = $mask
  $input.Location = New-Object System.Drawing.Size($left, $top)
  $input.Size = New-Object System.Drawing.Size($width, $height)
  $input
}

$form = New-Object System.Windows.Forms.Form
$form.Size = New-Object System.Drawing.Size(250, 160)

$form.Controls.Add((New-Label 'Username:' 60 20 20 10))
$user = New-Input 150 20 20 70
$form.Controls.Add($user)

$form.Controls.Add((New-Label 'Password:' 60 20 50 10))
$pass = New-Input 150 20 50 70 $true
$form.Controls.Add($pass)

$form.Controls.Add((New-Button 'OK' {$form.Close()} 70 23 85 70))
$form.Controls.Add((New-Button 'Cancel' {$user.Text=''; $pass.Text=''; $form.Close()} 70 23 85 150))

[void]$form.ShowDialog()

$username = $user.Text
$password = $pass.Text