if(window.XMLHttpRequest && !(window.ActiveXObject)) {  
        try {  
            req = new XMLHttpRequest();  
        } catch(e) {  
            req = false;  
        }  

    } else if(window.ActiveXObject) {  

        try {  
            req = new ActiveXObject("Msxml2.XMLHTTP");  
        } catch(e) {  
            try {  
                req = new ActiveXObject("Microsoft.XMLHTTP");  
            } catch(e) {  
                req = false;  
            }  
        }  
    }