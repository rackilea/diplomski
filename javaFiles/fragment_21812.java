saveProjectDetails(info: any) {
    const body = JSON.stringify(info);
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    alert(body);
    return this.http.post(this.postUrl, body, {headers: headers}).map((response: Response) => response.text());
  }