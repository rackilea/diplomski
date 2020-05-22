@Component
public MyComponent {
    @Autowired
    private ApplicationArguments  applicationArguments;

    public void method() {
        List<String> filenameArgs = applicationArguments.getOptionValues("filename")
    }
}