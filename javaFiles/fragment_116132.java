navController.addOnDestinationChangedListener { _, destination, _ ->

            for(menuItem in bottomNav.menu.iterator()){
                menuItem.isEnabled = true
            }

            val menu = bottomNav.menu.findItem(destination.id)
            menu?.isEnabled = false
}