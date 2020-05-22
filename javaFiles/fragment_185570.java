<script>        
    $(document).ready(function createUploader(){
      var uploader = new qq.FileUploaderValums({
        element: document.getElementById('fileUploader'),
        action: '/admin/Import',            
      });           
    });
</script>