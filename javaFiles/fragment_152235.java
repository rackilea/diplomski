beforeEach(async(() => {
    TestBed.configureTestingModule({
        imports: [],
        declarations: [UserComponent],
        providers: [
          { provide: UserService, useClass: MockUserService }] // <-- Here we have injected our Mock
    }).compileComponents();
}));