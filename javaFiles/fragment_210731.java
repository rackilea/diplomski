function validateForm() {
            var x = document.getElementById('firstName').value;
            if ((x == null || x == "")) {
                alert("EMPTY");
                //  document.getElementById('text').style.display = "block";  
                return false;
            } else {
                return true;
            }
        }