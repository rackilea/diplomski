boolean result = true;
for (int i = 0; i < main; ++i) {
    result = result && mClickedButtonIds.get(i) == mDesiredOrder[i];
    if (!result)
        break; // short-circuit out from loop if false
}

// now you can use "result" to test whether the condition matched all "main" ids
if (result) {
    // correct
} else {
    // bzzt, try again
}