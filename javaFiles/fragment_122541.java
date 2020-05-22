@RequestMapping(value="/paramtest", params={"paramA=true"})
@ResponseBody
public String function A() { return "A"; }

@RequestMapping(value="/paramtest", params={"paramA=true", "paramB=foobar"})
@ResponseBody
public String function B() { return "B"; }

@RequestMapping(value="/paramtest", params={"paramA=!true", "paramB=foo"})
@ResponseBody
public String function C() { return "C"; }