from inspect import getmembers, isfunction
import foo

f_list=[o[0] for o in getmembers(foo) if isfunction(o[1])]
for x in f_list:
    print("Build "+str(x))
    with open("helper_"+str(x)+".py","wt") as f:
        f.write("""import foo
import sys

arg_list=sys.argv[1::]
print(foo.{x}(*arg_list))""".format(x=x))