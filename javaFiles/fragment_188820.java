package com.theirs.web.controller;

@Controller
@RequestMapping("/base")
public class Base {
  @RequestMapping("/add")
  public String add() { ... }

  @RequestMapping("/update")
  public String update() { ... }

  @RequestMapping("/remove")
  public String remove() { ... }

  @RequestMapping("/show")
  public String show() { ... }
}

package com.mine.web.controller;

@Controller
@RequestMapping("/base")
public class ExtendedBase extends Base {
  @Override
  @RequestMapping("/add")
  public String add() { ... }
}