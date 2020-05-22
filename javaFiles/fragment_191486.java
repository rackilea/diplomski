getListe(): Promise<any> {
        let header = new Headers();
        header.append("authorization", localStorage.getItem("token"))
        let options = new RequestOptions({headers: header})
        return this.http.get(URL_API_REST + 'liste', options)
            .toPromise()
            .then(response => response.json())
            .catch(this.handleError);
    }