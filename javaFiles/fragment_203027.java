function validate(elem)
        {
            var anum=/(^923(\d){10}$)/; //using this regex after the number 923 
                                        // we are allowed to have 10 digits 
            if(anum.test(elem.value) == true)
            {
                elem.style.border="2px solid #0F0"; //green light
            }
            else
            {
                elem.style.border="2px solid #F00"; //red light
            }
        }