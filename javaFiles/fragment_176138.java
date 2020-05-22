let combinations = 0;
for a = 0 to 90
    for b = max(a+1, 1) to 120
        for c = max(b+1, 50) to 150
            for d = max(c+1, 20) to 200
                let e = 635 - a - b - c - d;
                if max(d+1, 50) <= e <= 250
                    let combinations = combinations + 1