const TodoInput = (props) => {
  let inputTitle, inputValue;
  const handleClick = () => {
    props.onAdd(inputTitle.value, inputValue.value);
    inputTitle.value = '';
    inputValue.value = '';

    input.focus();
  };

  return (
    <div>
      <input
        type="text"
        ref={(currentElement) => { inputTitle = currentElement; }}
        placeholder="title"
      />

      <input
        type="text"
        ref={(currentElement) => { inputValue = currentElement; }}
        placeholder="value"
      />

      <button
        type="button"
        onClick={handleClick}
      >
      add item
      </button>
    </div>
  );
};