outer:                  // Should be placed exactly before the loop
loopingConstructOne  {  // We can have statements before the outer but not inbetween the label and the loop          
    inner:
    loopingConstructTwo {
        continue;       // This goes to the top of loopingConstructTwo and continue.
        break;          // This breaks out of loopingConstructTwo.
        continue outer; // This goes to the outer label and reenters loopingConstructOne.
        break outer;    // This breaks out of the loopingConstructOne.
        continue inner; // This will behave similar to continue.
        break inner;    // This will behave similar to break.
    }
}