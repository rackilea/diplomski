ngOnInit() {
    this.userSvc.getAll().subscribe(result => {
        this.someListInsideResult = result['someList'];
        console.log('result: ', result);
        console.log('someListInsideResult: ', someListInsideResult);
    }
}