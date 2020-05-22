@GetMapping(value = "/date/{from}/{to}")
    public String DemoDate(@PathVariable(name = "from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from,
            @PathVariable(name = "to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to)
    {
        return from.toString() + " "+ to.toString();
    }