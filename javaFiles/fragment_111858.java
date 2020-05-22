$ sed -r 's/([a-zA-Z0-9]*-[a-zA-Z]*[0-9][a-zA-Z0-9]*|[a-zA-Z]*[0-9][a-zA-Z0-9]*-[a-zA-Z0-9]*)/{\1}/g' file
{a-45}
{45-a}
{45-45}
{a-aaa4}
{aaa4a-bbb5}
{a4aa-a}
a-a
b-b
-
a-
-a
{-4}
{4-}