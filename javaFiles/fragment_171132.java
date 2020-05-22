clientName:string;
lastName:string;
age:string;
resData: any;
selectedFile = null;

onFileSelected(event) {
this.selectedFile = event.target.files[0];
console.log(this.selectedFile);

onSubmit() {
const payload = new FormData();
payload.append('clientName', this.clientName);
payload.append('lastName', this.lastName);
payload.append('age', this.age);
payload.append('image', this.selectedFile, this.selectedFile.name);

this.http.post(`http://localhost:8080/apiHorsesClub/uploadTestEntity`,
payload).subscribe((data: any) => { this.resData = data;console.log(this.resData);
  });
}