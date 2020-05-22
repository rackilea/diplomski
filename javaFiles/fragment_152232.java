export class UserService{

getAll(): Observable<any> {
   this.headers = new HttpHeaders().set('X-Authorization', 'Bearer  ' + token).set('X- 
      Requested-With', 'XMLHttpRequest').set('Content-Type', 'application/json');
   return httpClient.get(url, {headers: headers});
}
}