class MyClass
{
    public function __call($name, array $args)
    {
        echo "You tried to call $name(".implode(',',$args)."). Silly user.";
    }
}

$k = new MyClass();
$k->doSomething(1,2,3); // You tried to call doSomething(1,2,3). Silly user.