export class Form {
  private file: File;
  private bookName: String;

  constructor(file:File, bookName: String) {
    this.file = file;
    this.bookName = bookName;
  }
}


public sendFormData(form: Form) {
  const formData = new FormData();
  formData.append('bookName', form.bookName);
  formData.append('file', form.file, form.file.name);

  console.log("sending to " + this.baseUrl + "uploadFile")
  return this.http.post(this.baseUrl + "uploadFile", formData, {responseType: 'text'});
}