String params = "groupname="+ URLEncoder.encode(groupname,"UTF-8") +
                    "&username="+ URLEncoder.encode(this.username,"UTF-8") +
                    "&password="+ URLEncoder.encode(this.password,"UTF-8") +
                    "&friendUserName=" +Arrays.toString(friend) +        
                    "&action="  + URLEncoder.encode("CreateGroup","UTF-8")+
                    "&";