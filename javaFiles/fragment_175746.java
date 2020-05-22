onFileChangeHandler = (e) => {
        e.preventDefault();
        this.setState({
            selectedFile: e.target.files[0]
        });
        const formData = new FormData();
        formData.append('file', this.state.selectedFile);
        //Append the rest data then send
        axios({
           method: 'post',
           url: 'myurl',
           data: formData,
           headers: {'Content-Type': 'multipart/form-data' }
        })
        .then(function (response) {
           //handle success
           console.log(response);
        }, 
        function(error) { 
           // handle error 
        });