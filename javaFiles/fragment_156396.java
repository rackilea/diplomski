@RequestMapping("/car")
class CarController {
    @Autowired
    private CarService service;

    @RequestMapping("/{color}")
    public Object getCarsByColor(@PathVariable String carColor) {
        return service.getCarsByColor(houseColor);
    }
}

@RequestMapping("/house")
class HouseController {
    @Autowired
    private HouseService service;

    @RequestMapping("/{houseId}")
    public Object getHouseById(@PathVariable int houseId) {
        return service.getHouseById(houseId);
    }
}