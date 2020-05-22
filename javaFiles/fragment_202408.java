function saveLoginNameToLocalStorage()  
                {
                 if(typeof(Storage)!=="undefined")//checks whether the browser support localStorage
                  {
                        // you dont want to create a variable by var variablename, 
                        // just give it as localStorage.yourVariableName, before assigning 
                        // any values the variable is shown as  undefined.
                         if(localStorage.userName &amp;&amp; localStorage.userName !="" &amp;&amp; localStorage.userName==document.getElementById("userName").value){
                            document.getElementById("redirectUrl").value=localStorage.redirectURI;
                        }
                        else{
                            localStorage.redirectURI="";
                            document.getElementById("redirectUrl").value="";
                        }
                         localStorage.userName=document.getElementById("userName").value;
                         localStorage.redirectURI="";
                  } 
                }