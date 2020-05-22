We want to find the power set of {1, 2, 3}.
    In order to do this, we take off 1 and find the power set of {2, 3}.
        In order to do this, we take off 2 and find the power set of {3}.
            In order to do this, we take off 3 and find the power set of {}.
                Which is {}.
            For everything above ({}), copy it over, then copy it over but add a 3.
            We have {{}, {3}}.
        For everything above ({}, {3}), copy it over, then copy it over but add a 2.
        We have {{}, {3}, {2}, {2, 3}}.
    For everything above ({}, {3}, {2}, {2, 3}), copy it over, then copy it over but add a 1.
    We have {{}, {3}, {2}, {2, 3}, {1}, {1, 3}, {1, 2}, {1, 2, 3}}.