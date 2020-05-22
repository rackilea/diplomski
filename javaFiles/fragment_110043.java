val navigationController = nav_host_fragment.findNavController()

    if (navigationController.currentDestination?.id == R.id.fragmentA) {
        (nav_host_fragment.childFragmentManager.fragments[0] as FragmentA).doSomething()

    }