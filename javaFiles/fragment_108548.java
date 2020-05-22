getPDF(){
const url = `${this.serviceUrl}/pdf`;

const httpOptions = {
  'responseType'  : 'arraybuffer' as 'json'
   //'responseType'  : 'blob' as 'json'        //This also worked
};

return this.http.get<any>(url, httpOptions);

}