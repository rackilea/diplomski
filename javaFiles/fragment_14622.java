login() {

    ...

    this.authService.auth(...).subscribe(() => {
       // code when it is successful
    }, (err:HttpErrorResponse) => {
       console.log(err.error.message);
    }
}