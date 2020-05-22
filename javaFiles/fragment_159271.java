constructor(
  private yourService: YourService,
) { }

ngOnInit() {
  this.yourService.executeHelloWorldBeanServiceWithPathVariable('someName').subscribe(res => {
    console.log(res);
    // do the rest here
  })
}