MainFunction strategy = defaultFunction;
switch(option) {
    case "vanilla":
         strategy = vanillaFunction;
         break;
    case "different":
         strategy = differentFunction;
         break;
}
strategy.main();