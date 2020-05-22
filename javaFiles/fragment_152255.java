function upload()
{
          var x = document.getElementById("plan_upload");
          var numOfFiles= x.files.length;
          for (var i = 0; i < numOfFiles; i++) 
          {
                var file = x.files[i];
                var plan_type='${param.par_type}'
                var formdata = new FormData();
                formdata.append("plan_upload", file);
                var ajax = new XMLHttpRequest();
                ajax.addEventListener("error", errorHandlerPlanUpload, false);
                ajax.addEventListener("abort", abortHandlerPlanUpload, false);
                ajax.onreadystatechange = function  ()
                {   
                    if (ajax.readyState==4 && ajax.status==200)
                    {
                        if(i== numOfFiles-1)
                        {
                            alert('Загрузка файлов успешно завершена!');
                            window.opener.location.reload()
                            window.close();
                        }               
                    }
                }  
                ajax.open("POST", "MultipleFileUpload?par_type="+plan_type,false);
                ajax.send(formdata);
            }
}