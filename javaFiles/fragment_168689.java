String properties = "status.availability-state available\nstatus.enabled-state enabled\nstatus.status-reason The pool is available";

Map<String, String> map = Arrays.stream(properties.split("\n"))
                    .collect(Collectors.toMap(s -> s.split(" ")[0], s -> s.split(" ", 2)[1]));

System.out.println(map.get("status.status-reason"));