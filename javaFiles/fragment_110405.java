function check_all_in_document(doc)
{
   var c = new Array();
   c = doc.getElementsByTagName('input');

   for (var i = 0; i < c.length; i++)
   {
       if (c[i].type == 'checkbox')
       {
           c[i].checked = true;
       }
   }
}