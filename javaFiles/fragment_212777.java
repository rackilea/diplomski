switch (item.outcome) {
    case HOME:
        holder.homeCheckBox.setChecked(true);
        holder.drawCheckBox.setChecked(false);
        holder.awayCheckBox.setChecked(false);
        break;

    case DRAW:
        holder.homeCheckBox.setChecked(false);
        holder.drawCheckBox.setChecked(true);
        holder.awayCheckBox.setChecked(false);
        break;

    case AWAY:
        holder.homeCheckBox.setChecked(false);
        holder.drawCheckBox.setChecked(false);
        holder.awayCheckBox.setChecked(true);
        break;

    default:
        holder.homeCheckBox.setChecked(false);
        holder.drawCheckBox.setChecked(false);
        holder.awayCheckBox.setChecked(false);
        break;
}