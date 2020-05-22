function update()
{
  var link = document.getElementById("lnk");
  var result = submitFormAsync('Form');
  link.href += "&var3=" + result;
  return;
}