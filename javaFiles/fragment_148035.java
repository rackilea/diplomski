public formdata = new FormData(); 
    onSubmit() { 

    this.resetform();  //Order matters here
    let headers: any = new Headers(); 
    headers.append('Content-type', 'undefined'); 

    formData.append("selectFile", this.formData); 
    const req5 = new HttpRequest('POST', 'url as hosted on TOMCAT', formData, 
    reportProgress: true, 
    responseType: 'text' 
    }); 
    return this.httpClient.request(req5).subscribe(e => {( 
    console.log(e); 

    )} 
    } 

    resetform() { 
    this.formData = new FormData(); 
    }