$(".ct-color-specs").on("click",".color-spec-file-delete",function() {
                    var deletedFileName = $(this).parents(".ct-attached-color-spec-files").find("a").text().split('/').pop().split('\\').pop();;
                    alert("deletedFileName--->" + deletedFileName);
                     $.ajax({
                        url : "/Application/removeFile/"+deletedFileName,
                        type: 'GET',  
                        success: function (res) {  
                            console.log(data);
                        } 
                    });
                });