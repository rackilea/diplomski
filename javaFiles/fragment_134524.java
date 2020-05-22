public class EditMMYY extends AppCompatEditText implements TextWatcher
{
    private String sPrev = "";
    private int iMon = 0;
    private int iYear = 0;

    private void InitValue()
    {
        setInputType(InputType.TYPE_CLASS_NUMBER);
        setFilters(new InputFilter[] {new InputFilter.LengthFilter(5)});
        setHint("MM/YY");
    }

    public EditMMYY(Context context)
    {
        super(context);
        InitValue();
    }

    public EditMMYY(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        InitValue();
    }

    public EditMMYY(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        InitValue();
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count)
    {
        // Chequeo que el ingreso sea MM/YY
        String sNew = s.toString();
        int newLen = sNew.length();

        if(sNew.equals(sPrev))
        {
            return;
        }
        switch(newLen)
        {
            case 0:
                iMon = 0;
                iYear = 0;
                sPrev = sNew;
                break;
            case 1:
                iMon  = Integer.parseInt(sNew);
                iYear = 0;
                if(sPrev.length() == 0 && iMon > 1)
                {    // Si se escribe un número mayor que 1, lo tomo como mes
                    sPrev = String.format("%02d/", iMon);
                }
                else
                {
                    sPrev = sNew;
                }
                break;
            case 2:
                iMon  = Integer.parseInt(sNew);
                iYear = 0;
                if(sPrev.length() == 1)
                {
                    // Si ya es un mes válido, lo completo, sino dejo
                    // sPrev sin cambios hasta que se ingrese algo válido
                    if(iMon >= 1 && iMon <= 12)
                    {
                        sPrev = String.format("%02d/", iMon);
                    }
                }
                else
                {
                    sPrev = sNew;
                }
                break;
            case 3:
                iMon  = Integer.parseInt(sNew.substring(0, 2));
                iYear = 0;
                if(sPrev.length() == 2)
                {
                    iMon = Integer.parseInt(sNew.substring(0, 2));
                    iYear = Integer.parseInt(sNew.substring(2, 3));
                    sPrev = String.format("%02d/%d", iMon, iYear);
                }
                else
                {
                    sPrev = sNew;
                }
                break;
            case 4:
            case 5:
                iMon = Integer.parseInt(sNew.substring(0, 2));
                iYear = Integer.parseInt(sNew.substring(3, newLen));
                sPrev = sNew;
                break;
            default:
                sPrev = sNew;
                break;
        }
        setText(sPrev);
        setSelection(sPrev.length());
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after)
    {
    }

    @Override
    public void afterTextChanged(Editable s)
    {

    }

    public int getMon()
    {
        return iMon;
    }

    public int getYear()
    {
        return iYear;
    }
}