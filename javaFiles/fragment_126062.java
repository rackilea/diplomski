switch (list.getSelectedItem()) {
    case "Flashlight": {
        toggleFlashlight();
        break;
    }

    case "Health Potion": {
        usePotion();
        break;
    }

    case "Snack": {
        useSnack();
        break;
    }
}