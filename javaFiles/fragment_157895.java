state_dict = {}
    cf = open(censusfile, "rt")
    lines = cf.readlines()
    for line in lines[1:]:  # we skip 1st line
        arr = line.strip().split(',')
        town = arr[0]
        state = arr[1]
        numbers = [int(x) for x in arr[2:]]
        add_items(state_dict, state, town, numbers)
    print(state_dict)