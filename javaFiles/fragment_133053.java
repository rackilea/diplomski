searchControl = new FormControl();

ngOnInit() {
    this.searchControl.valueChanges
        .debounceTime(150)
        .distinctUntilChanged()
        .subscribe(() => {
            if (!this.dataSource) {
                return;
            }
            this.dataSource.filter = this.filter.nativeElement.value;

        });
}