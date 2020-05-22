function func_search()
            {
                var srchdata = document.getElementById('searchitem').value; 
                //alert(srchdata);  
                if(srchdata == "")
                {
                    alert("Enter Search Criteria...");
                }
                else
                {
                    document.location.href="your servlet name here";    
                }               
            }