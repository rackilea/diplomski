<?php

$apps = 100;
for ($i = 0; $i < $apps; $i++) {
    if ($i % 3 == 0) {
        $row1 .= "<td>" .$i ."</td>";
    }
    if ($i % 3 == 1) {
        $row2 .= "<td>" .$i ."</td>";
    }
    if ($i % 3 == 2) {
        $row3 .= "<td>" .$i ."</td>";
    }
}
?>
<table>
<tr><?php echo $row1; ?></tr>
<tr><?php echo $row2;?></tr>
<tr><?php echo $row3; ?></tr>
</table>