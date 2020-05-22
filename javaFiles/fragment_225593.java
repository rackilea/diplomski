$.ajax({
            url:approveUrl,
            data:JSON.stringify(yourdata),
//            dataType:'json',
            type:'post',
//            traditional: true,
            success:function (response) {
                hideProgressBar(parent.document)
                if (response.result==false){
                    alert(response.msg);
                    return;
                }

//                document.location.reload();
            }

        })