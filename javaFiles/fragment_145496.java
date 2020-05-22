@RequestMapping("/create")
@ResponseBody Hospital create(@RequestBody Hospital hospital){

    hospital.getDepartments().forEach(department->department.setHospital(hospital));
    hospital = hospitalService.save(hospital);

    return hospital;
}