profileForm = new FormGroup({
clientName : new FormControl(''),
lastName : new FormControl(''),
age : new FormControl('')
});

selectedFile = null;
public data:clientClass = new clientClass();

onFileSelected(event) {
this.selectedFile = event.target.files[0];
console.log(this.selectedFile);
}

onSubmit() {
let object = this.profileForm.value;
const payload = new FormData();
payload.append("addClient",JSON.stringify(object));
payload.append("image", this.selectedFile, this.selectedFile.name);
this.http.post(`http://localhost:8080/yourAPI/uploadTestEntity`,payload, { 
responseType: 'text'}).subscribe(
  (object) => {
    this.profileForm.reset();
  });
}