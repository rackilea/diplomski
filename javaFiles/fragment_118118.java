usleep(10);//while java app is running;
$pdf = '';
while (($pdfBuff = fgets($pipes[1],1024)) !== null)
{
    $pdf.=$pdfBuff;//or echo, or whatever
}
fclose($pipes[1]);